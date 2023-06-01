<template>
  <div>
    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(item,i) in state" :key="i">
            <Card :item = "item"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Card from "@/components/Card";
import axios from "axios";

export default {
  name: "Home",
  components: {Card},
  data() {
    return{
      state : [],
      alert : false
    }
  },
  created() {

  },
  mounted() {
    this.getState();
  },
  computed: {},
  methods: {
    getState : function(){
      axios.get("/api/items").then((res)=>{
        if(res.statusText == "OK"){
          this.state = res.data;
        }else{
          this.alert = true;
        }
      });
    }
  }
}
</script>
<style scoped>

</style>

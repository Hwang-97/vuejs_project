<template>
    <div class="container">
        <div class="selects w-auto">
            <select class="form-select" v-model="selectedOption">
                <option
                    v-for="type in types"
                    :key="type"
                    >{{type}}</option>
            </select>
        </div>
        <input
                class="form-control w-75"
                v-model="title"
                type="text"
                placeholder="제목 또는 내용을 입력해 주세요."
                @input = "this.title = $event.target.value"
                @keydown.enter="searchBoard"/>
        <input
            class="btn btn-primary w-auto"
            value="검색"
            @click="searchBoard"/>
    </div>

</template>

<script>
    export default {
        props:{
          boardFlag : {
            flag: Boolean,
            default: false
          },
          list : {
            flag: Array,
            default: []
          }
        },
        data(){
          return{
              title:'',
              types:['제목','내용'],
              selectedOption: '제목'
          }
        },
        methods:{
            searchBoard(){
                if(this.boardFlag){
                  this.$emit('search:fnGetList',{typeFlag: this.selectedOption == '제목'? 'title' : 'content' ,content : this.title});
                }else {
                  let url = "board";
                  let emptyInput = this.title.trim().length <= 0 ? false : true;
                  if(emptyInput) {
                      this.$router.push({
                          name: url,
                          query: {
                              typeFlag: this.selectedOption == '제목'? 'title' : 'content',
                              content : this.title
                          },
                      });
                  }else{
                      alert("검색어 입력")
                  }
                }
            }
        },
        name: "Search"
    }
</script>

<style lang="scss" scoped>
    .container{
        margin-top:20px;
        display: flex;
        .selects{
            display: flex;
        }
    }
</style>

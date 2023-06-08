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
                v-model="searchText"
                type="text"
                placeholder="제목 또는 내용을 입력해 주세요."
                @input = "this.searchText = $event.target.value"
                @keydown.enter="searchBoard"/>
        <input
            class="btn btn-primary w-auto"
            value="검색"
            @click="searchBoard"/>
    </div>

</template>

<script>
    import store from '../store';
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
              searchText: "",
              types:['제목','내용'],
              selectedOption: "",
              storeData:{}
          }
        },
        computed:{
            searchText(){
                let searchText = this.$store.state.search.searchText;
                return searchText == "" ? "" : searchText;
            },
            selectedOption(){
                let flag = this.$store.state.search.flag;
                return flag == "" ? "제목" : flag;
            }
        },
        methods:{
            searchBoard(){
                // this.$store.commit('search/setData', { flag: 'newFlag', context: 'newContext' });
                if(this.boardFlag){
                  this.$emit('search:fnGetList',{typeFlag: this.selectedOption == '제목'? 'title' : 'content' ,searchText : this.searchText});
                }else {
                  let url = "board";
                  let emptyInput = this.searchText.trim().length <= 0 ? false : true;
                  if(emptyInput) {
                      this.$router.push({
                          name: url,
                          query: {
                              typeFlag: this.selectedOption == '제목'? 'title' : 'content',
                              searchText : this.searchText
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

<template>
    <div class="container">
        <div class="selects w-auto">
            <select class="form-select" :value="selectedOption" @change="changeSelect($event)">
                <option
                    v-for="obj in types"
                    :key="obj.value"
                    :value="obj.value"
                    >{{obj.text}}</option>
            </select>
        </div>
        <input
                class="form-control w-75"
                :value="searchText"
                type="text"
                placeholder="제목 또는 내용을 입력해 주세요."
                @input="changeInput($event)"
                @keydown.enter="searchBoard"/>
        <input
            class="btn btn-primary w-auto"
            value="검색"
            @click="searchBoard"/>
    </div>

</template>

<script>
    import { createNamespacedHelpers } from 'vuex'
    const searchHelper = createNamespacedHelpers('search');
    export default {
        props:{
          boardFlag : {
            flag: Boolean,
            default: false
          },
        },
        data(){
          return{
              types:[{value : "title"  , text :'제목'}
                    ,{value : "content", text :'내용'}],
              searchText: "",
              selectedOption: ""
          }
        },
        computed:{
            // ...searchHelper.mapGetters({
            //     searchText : state => state.searchText,
            //     flag       : state => state.typeFlag
            // }),
            // 하위는 helper를 사용하지 않은 기존 방식
            searchText(){
                let searchText = this.$store.getters["search/getSearchText"];
                return searchText;
            },
            selectedOption(){
                let flag = this.$store.getters['search/getTypeFlag']; // getter 호출
                return flag;
            }
        },
        methods:{
            // ...searchHelper.mapMutations({
            //     changeInput: 'setSearchText'
            // }),
            changeInput(e){
                this.$store.commit('search/setSearchText',e.target.value);
                return e.target.value;
            },
            changeSelect(e){
                this.$store.commit('search/setTypeFlag',e.target.value);
            },
            searchBoard(){
                if(this.boardFlag){
                  this.$emit('search:fnGetList');
                }else {
                  this.$router.push({name: "board"});
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

<template>
    <div class="container">
        <div class="selects w-auto">
            <select class="form-select">
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
                @keydown.enter="searchBoard"/>
        <input
            class="btn btn-primary w-auto"
            value="검색"
            @click="searchBoard"/>
    </div>

</template>

<script>
    export default {
        data(){
          return{
              title:'',
              types:['제목','내용']
          }
        },
        methods:{
            searchBoard(){
                let url = "/board";
                let emptyInput = this.title.trim().length <= 0 ? false : true;
                this.$router.replace({
                    path : emptyInput ? url : "/",
                    query : {
                            typeFlag : "제목",
                            content  : "검색"
                            } ,
                });

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

<template>
    <Search
        :board-flag="true"
        @fnGetList="fnGetList">
    </Search>
    <div class="container board">
        <div class="table-responsive small">
            <table class="table table-striped ">
                <colgroup>
                    <col width="100px"/>
                    <col width="100px"/>
                    <col width="100px"/>
                    <col width="*"/>
                    <col width="200px"/>
                    <col width="100px"/>
                </colgroup>
                <thead>
                <tr table-header>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>작성일자</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(row, idx) in list"
                    :key="idx"
                    @click="fnView(`${row.id}`)">
                    <td>{{ row.id }}</td>
                    <td>{{ row.title }}</td>
                    <td>{{ row.author }}</td>
                    <td>{{ row.content }}</td>
                    <td>{{ row.createdAt.substr(0,10) }}</td>
                    <td>
                        <div
                            @click="deleteRow(`${row.id}`)"
                            v-if="row.isDeletable"
                            class="btn btn-primary">
                            삭제
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    import Search from "../../components/Search.vue";
    import axios from "axios";
    export default {
        components:{
            Search
        },
        props:{
            typeFlag : {
                type    : String,
                default : ""
            },
            content : {
                type    : String,
                default : ""
            }
        },
        data() { //변수생성
            return {
                requestBody: {}, //리스트 페이지 데이터전송
                list: {}, //리스트 데이터
                no: '', //게시판 숫자처리
                paging: {
                    block: 0,
                    end_page: 0,
                    next_block: 0,
                    page: 0,
                    page_size: 0,
                    prev_block: 0,
                    start_index: 0,
                    start_page: 0,
                    total_block_cnt: 0,
                    total_list_cnt: 0,
                    total_page_cnt: 0,
                }, //페이징 데이터
                page: this.$route.query.page ? this.$route.query.page : 1,
                size: this.$route.query.size ? this.$route.query.size : 10,
                keyword: this.$route.query.keyword,
                paginavigation: function () { //페이징 처리 for문 커스텀
                    let pageNumber = [] //;
                    let start_page = this.paging.start_page;
                    let end_page = this.paging.end_page;
                    for (let i = start_page; i <= end_page; i++) pageNumber.push(i);
                    return pageNumber;
                }
            }
        },
        mounted() {
            this.fnGetList()
        },
        methods: {
            deleteRow(id){
              console.log(id);
            },
            fnView(id){
                const url = "/board/detail"
                this.$router.replace({
                     path: url,
                     query: {
                         id: id
                     },
                 });
            },
            fnGetList(data) {
              // axios.get("/api/boardList", {
              //   params: data
              // }).then((res)=>{
              //   if(res.statusText == "OK"){
              //     this.list = res.data;
              //   }else{
              //     this.alert = true;
              //   }
              // });
                this.list = [
                        {
                            id : "1",
                            title : "제목",
                            author : "테스터",
                            content : "테스트 중 입니다.....",
                            createdAt : "2023-06-02 10:35:12",
                            isDeletable : false
                        },
                        {
                            id : "2",
                            title : "제목",
                            author : "테스터",
                            content : "테스트 중 입니다.....",
                            createdAt : "2023-06-02 10:35:12",
                            isDeletable : false
                        },
                        {
                            id : "3",
                            title : "제목",
                            author : "테스터",
                            content : "테스트 중 입니다.....",
                            createdAt : "2023-06-02 10:35:12",
                            isDeletable : false
                        },
                    ]
            }
        },
        name: "Board"
    }
</script>

<style lang="scss" scoped>
    .board{
        margin-top: 30px;
    }
    th {
        background-color: #64818e;
        color:white;
        font-weight: bold;
        font-family: "Oswald", sans-serif;
    }
    tbody{
        tr:hover{
            cursor: pointer;
        }
    }
</style>

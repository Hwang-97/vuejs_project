<template>
    <Search
        :board-flag="true">
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
                    @click="fnView(`${row.idx}`)">
                    <td>{{ row.idx }}</td>
                    <td>{{ row.title }}</td>
                    <td>{{ row.author }}</td>
                    <td>{{ row.content }}</td>
                    <td>{{ row.created_at }}</td>
                    <td>
                        <div
                            v-if="row.delete"
                            class="btn btn-primary">
                            삭제
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <Modal v-show="true"></Modal>
</template>

<script>
    import Search from "../components/Search";
    import Modal from "../components/Modal";
    export default {
        components:{
            Modal,
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
                showModal: false,
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
            fnView(idx){
                this.showModal = !this.showModal;
            },
            fnGetList() {
                this.list = [
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 2,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 3,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": false
                    },
                    {
                        "idx": 1,
                        "title": "제목1",
                        "author": "작성자1",
                        "content": "내용1",
                        "created_at": "작성일시1",
                        "delete": true
                    }
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

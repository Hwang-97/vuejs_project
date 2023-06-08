<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        상세화면
                    </div>
                    <div class="card-body">
                        <table class="table mt-3">
                            <tbody>
                            <tr>
                                <th scope="row" class="col-1 text-center">게시글 ID</th>
                                <td>
                                    {{detail.id}}
                                </td>
                            </tr>
                            <tr>
                                <th scope="row" class="col-1 text-center">제목</th>
                                <td>
                                    <input v-model="detail.title" :disabled="!isEditMode"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row" class="col-1 text-center">작성자</th>
                                <td>
                                    <input v-model="detail.author" :disabled="!isEditMode"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"
                                    v-text="isEditMode?'수정일자':'작성일자'"
                                    class="col-1 text-center"></th>
                                <td>{{ detail.createdAt.substr(0, 10) }}</td>
                            </tr>
                            <tr>
                                <th scope="row"
                                    class="col-1 text-center">
                                    내용
                                </th>
                                <td>
                                    <textarea v-model="detail.content" :disabled="!isEditMode"></textarea>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary" @click="list">
                            목록
                        </button>
                        <button class="btn"
                                @click="toggleEditMode()"
                                :class="isEditMode?'btn-warning':'btn-primary'">
                            {{ isEditMode ? '저장' : '수정' }}
                        </button>
                        <button class="btn btn-danger"
                                @click="del"
                                v-if="detail.isDeletable">
                            삭제
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import axios from "axios";

    export default {
        data() {
            return {
                detail: {
                    id: "",
                    title: '제목',
                    author: '테스터',
                    content: '테스트 중 입니다.....',
                    createdAt: '2023-06-02 10:35:12',
                    isDeletable: true,
                },
                isEditMode: false,
            };
        },
        mounted() {
            this.detail.id = this.$route.query.id;
            this.getDetailData();
        },
        methods: {
            getDetailData() {
                axios.get("/api/boardDetail", {
                    params: {"id" : this.detail.id}
                }).then((res) => {
                    if (res.statusText == "OK") {
                        this.list = res.data;
                    } else {
                        alert("데이터가 존재하지 않습니다. 리스트 화면으로 돌아갑니다.");
                        this.loadList();
                    }
                });
            },

            list() {
                if (this.isEditMode) {
                    if (confirm("수정중이던 내용을 저장하시겠습니까?")) {
                        this.toggleEditMode()
                    }
                }
                this.loadList();
            },
            del() {
                if (confirm("해당 내용을 삭제하시겠습니까?")) {
                    this.loadList();
                }
            },
            toggleEditMode() {
                if (this.isEditMode) {
                    var today = this.$utils.getNow();
                    this.detail.createdAt = today.toString()
                    // 저장 로직 구현
                    alert('저장되었습니다.');
                }
                this.isEditMode = !this.isEditMode;
            },
            loadList() {
                let url = "/board";
                this.$router.replace({
                    path: url,
                    query: {
                        typeFlag: "",
                        content: ""
                    },
                });
            }
        }
        ,
    }
    ;
</script>

<style lang="scss" scoped>
    .card-footer {
        display: flex;
        justify-content: flex-end;

        button {
            margin-left: 5px;
        }
    }

    input,
    textarea {
        width: 100%;
    }
</style>

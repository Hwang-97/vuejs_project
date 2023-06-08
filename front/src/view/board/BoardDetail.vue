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
                                <td>{{ detail.createAt.substr(0, 10) }}</td>
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
                            <tr>
                                <th scope="row"
                                    class="col-1 text-center">
                                    게시글 삭제
                                </th>
                                <select class="form-select" v-model="detail.isDeletable" :disabled="!isEditMode">
                                  <option :value=true>
                                    삭제 가능
                                  </option>
                                  <option :value=false>
                                    삭제 불가
                                  </option>
                                </select>
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
                    title: "",
                    author: "",
                    content: "",
                    createAt: "",
                    isDeletable: null,
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
                axios.get("/api/board/detail", {
                    params: {"id" : this.detail.id}
                }).then((res) => {
                    if (res.statusText == "OK") {
                        this.detail = Object.assign(this.detail, res.data);
                        console.log(this.detail);
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
                    axios.delete("/api/board", {
                        params: {"id" : this.detail.id}
                    }).then((res) => {
                        if (res.statusText == "OK") {
                            alert("정상적으로 삭제되었습니다.")
                            this.loadList();
                        } else {
                            alert("삭제할 데이터가 존재하지 않습니다.\r\n리스트 화면으로 돌아갑니다.");
                            this.loadList();
                        }
                    });
                }
            },
            toggleEditMode() {
                if (this.isEditMode) {
                    // 공통 스크립트 구현 예시를 위한 코드
                    // var today = this.$utils.getNow();
                    // this.detail.createAt = today.toString()
                    this.saveCallAxios();
                }
                this.isEditMode = !this.isEditMode;
            },
            loadList() {
                this.$router.replace({path: "/board"});
            },
            saveCallAxios(){
              let data = this.detail;
              axios.post("/api/board/update", data, {
                headers: {
                  "Content-Type": "application/json"
                }
              }).then((res)=>{
                if (res.statusText == "OK") {
                  alert('저장되었습니다.');
                }else{
                  alert("저장중 오류 발생");
                }
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

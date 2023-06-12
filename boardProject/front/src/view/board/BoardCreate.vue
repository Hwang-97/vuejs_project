<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        게시글 작성
                    </div>
                    <div class="card-body">
                        <table class="table mt-3">
                            <tbody>
                            <tr>
                                <th scope="row" class="col-1 text-center">게시글 ID</th>
                                <td>
                                    ID는 저장시 자동생성 됩니다.
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
                                    class="col-1 text-center">작성일자</th>
                                <td>{{ detail.createAt.substr(0, 10) }}</td>
                            </tr>
                            <tr>
                                <th scope="row"
                                    class="col-1 text-center align-middle">
                                    세부 내용
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
                    isDeletable: true,
                },
                isEditMode: true,
            };
        },
        mounted() {
            this.detail.createAt = this.$utils.getNow();
            // this.detail.id = this.$route.query.id;
            // this.getDetailData();
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
                    }else{
                        this.loadList();
                    }
                }
            },
            toggleEditMode() {
                if (this.isEditMode) {
                    // 공통 스크립트 구현 예시를 위한 코드
                    // var today = this.$utils.getNow();
                    // this.detail.createAt = today.toString()
                    this.saveCallAxios();
                }
            },
            loadList() {
                this.$router.replace({path: "/board"});
            },
            saveCallAxios(){
              let data = this.detail;
              axios.post("/api/board/create", data, {
                headers: {
                  "Content-Type": "application/json"
                }
              }).then((res)=>{
                if (res.statusText == "OK") {
                  alert('저장되었습니다.');
                  this.loadList();
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

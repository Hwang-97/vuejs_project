<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        상세화면
                    </div>
                    <div class="card-body">
                        <table class="table mt-4">
                            <tbody>
                            <tr>
                                <th scope="row">제목</th>
                                <td>
                                    <input v-model="detail.title" :disabled="!isEditMode"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">작성자</th>
                                <td>
                                    <input v-model="detail.author" :disabled="!isEditMode"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row" v-text="isEditMode?'수정일자':'작성일자'"></th>
                                <td>{{ detail.createdAt.substr(0, 10) }}</td>
                            </tr>
                            <tr>
                                <th scope="row">내용</th>
                                <td>
                                    <textarea v-model="detail.content" :disabled="!isEditMode"></textarea>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary" @click="toggleEditMode()">
                            {{ isEditMode ? '저장' : '수정' }}
                        </button>
                        <button
                                class="btn btn-danger"
                                @click="delete"
                                v-if="detail.isDeletable"
                        >
                            삭제
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        props: {
            id: {
                typeFlag: String,
                default: '',
            },
        },
        data() {
            return {
                detail: {
                    id: '1',
                    title: '제목',
                    author: '테스터',
                    content: '테스트 중 입니다.....',
                    createdAt: '2023-06-02 10:35:12',
                    isDeletable: true,
                },
                isEditMode: false,
            };
        },
        methods: {
            delete() {
            },
            toggleEditMode() {
                if (this.isEditMode) {
                    var today =  this.$utils.getNow();
                    this.detail.createdAt = today.toString()
                    // 저장 로직 구현
                    alert('저장되었습니다.');
                }
                this.isEditMode = !this.isEditMode;
            },
        },
    };
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

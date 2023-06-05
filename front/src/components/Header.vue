<template>
    <header>
        <Logo/>
        <div class="nav nav-pills">
            <div v-for="nav in navigations"
                 :key="nav.name"
                 class="nav-item">
                <RouterLink
                    :to="nav.href"
                    active-class="active"
                    class="nav-link">
                    {{nav.name}}
                </RouterLink>
            </div>
        </div>
        <div class="btn-group ml-auto">
          <div class="btn btn-warning info" @click="openModal">질문</div>
        </div>
    </header>
    <Modal v-show="showModal" @close="closeModal">
    </Modal>
</template>

<script>
    import Modal from "./Modal"
    import Logo from "./Logo"
    export default {
        components:{
            Logo,
            Modal
        },
        data(){
            return{
                showModal: false,
                navigations:[
                    {
                        name: "Home",
                        href: "/"
                    },
                    {
                        name: "Board",
                        href: "/board"
                    },
                    {
                        name: "Etc",
                        href: "/etc"
                    },
                ]
            }
        },
        methods:{
            openModal() {
              this.showModal = true; // 모달을 열기 위해 상태를 true로 설정합니다.
            },
            closeModal() {
              this.showModal = false; // 모달을 닫기 위해 상태를 false로 설정합니다.
            },
        },
        name: "Header"
    }
</script>
<style lang="scss" scoped>
    header{
        height: 100px;
        padding: 0 60px;
        display: flex;
        align-items: center;
        .logo{
            margin-right: 40px;
        }
    }
    .info {
      margin-left: auto;
    }

    .ml-auto {
      margin-left: 1000px;
    }
</style>

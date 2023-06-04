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
    </header>
</template>

<script>
    import Logo from "./Logo"
    export default {
        components:{
            Logo
        },
        data(){
            return{
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
</style>

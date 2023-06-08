<template>
    <RouterLink
        to="/"
        class="logo">
        <img src="../assets/logo.png">
        <span> VUE BOARD</span>
    </RouterLink>
</template>

<script>
    export default {
        name: "Logo.vue"
    }
</script>

<style lang="scss" scoped>
    @import "../scss/main";
    .logo{
        font-family: 'Roboto', sans-serif;
        font-size: 30px;
        color: #000;
        text-decoration: none;
        &:hover{
            color : $black;
        }
        span{
            color: $primary;
        }
    }
</style>

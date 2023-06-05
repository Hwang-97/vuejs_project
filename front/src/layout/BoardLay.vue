<template>
    <router-view></router-view>
</template>

<script>
    export default {
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
        created() {
          console.log(this.$route.params.typeFlag);
          console.log(this.$route.params.content);
        },
        name: "BoardLay"
    }
</script>

<style scoped>

</style>

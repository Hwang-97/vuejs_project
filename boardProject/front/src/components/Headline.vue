<template>
    <div class="container"
         :class="home?'home':''">
        <h1 v-if="home"><span>{{text}}</span></h1>
        <h5 v-else="home"><span>{{text}}</span></h5>
    </div>
</template>

<script>
    export default {
        props:{
            text : {
                type : String,
                default : "조회하실 내용을 작성해 주세요."
            },
            home : {
                type: Boolean,
                default: true
            }
        },
        name: "Headline"
    }
</script>

<style lang="scss" scoped>
    @import "../scss/main.scss";
    .home{
        padding-top: 150px;
    }
    h1{
        line-height: 1;
        font-family: "Oswald", sans-serif;
        font-size: 30px;
        span{
            color: $primary;
        }
    }
</style>

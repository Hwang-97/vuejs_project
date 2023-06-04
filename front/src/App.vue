<template>
  <Header/>
  <RouterView/>
</template>

<script>
  import Header from "~/components/Header";
  export default {
    components:{
      Header
    }
  }
</script>
<style lang="scss">
@import "./scss/main";
body{
    line-height: 1.4;
    font-family: 'Roboto', sans-serif;
}
</style>

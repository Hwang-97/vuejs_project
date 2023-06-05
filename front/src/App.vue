<template>
  <Header/>
  <RouterView/>
  <Footer/>
</template>

<script>
  import Header from "~/components/Header";
  import Footer from "./components/Footer";
  export default {
    components:{
      Footer,
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

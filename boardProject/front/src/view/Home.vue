<template>
  <HomeLay>
    <Headline/>
    <Search/>
  </HomeLay>
</template>

<script>
    import Search from "../components/Search.vue";
    import Headline from "../components/Headline.vue";
    import HomeLay from "../layout/HomeLay.vue";
    export default {
        name: "Home",
        components: {
          HomeLay,
            Headline,
            Search
        }
    }
</script>
<style lang="scss" scoped>
    .container{
        display: flex;
        .selects{
            display: flex;
        }
    }
</style>

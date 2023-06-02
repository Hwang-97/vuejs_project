<template>
    <Headline/>
    <Search/>
</template>

<script>
    import Search from "../components/Search";
    import Headline from "../components/Headline";
    export default {
        name: "Home",
        components: {
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

<template>
  {{ $route.params.id }}
    <router-view></router-view>
</template>

<script>
    export default {
        props:[
            'id'
        ],
        created() {
        },
        name: "BoardLay"
    }
</script>

<style scoped>

</style>

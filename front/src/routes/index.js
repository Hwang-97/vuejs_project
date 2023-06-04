import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "../view/Home.vue"
import Etc from "../view/Etc.vue"
import Board from "../view/Board.vue"

export default createRouter({
    history:createWebHashHistory(),
    routes: [
        {
            path: "/",
            component:Home
        },
        {
            path: "/board",
            component:Board
        },
        {
            path: "/etc",
            component:Etc
        },
    ]
})

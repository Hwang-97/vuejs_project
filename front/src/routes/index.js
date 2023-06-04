import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "./Home"
import Etc from "./Etc"
import Board from "./Board"

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

import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "../view/Home.vue"
import Etc from "../view/Etc.vue"
import Board from "../view/board/Board.vue"
import BoardDetail from "../view/board/BoardDetail";
import BoardLay from "../layout/BoardLay";

export default createRouter({
    history:createWebHashHistory(),
    routes: [
        {
            path: "/",
            component:Home
        },
        {
            path: "/board",
            component:BoardLay,
            children:[
                {
                    path: "",
                    name: "board",
                    component: Board,
                },
                {
                    path: "detail",
                    component: BoardDetail
                }
            ]
        },
        {
            path: "/etc",
            component:Etc
        },

    ]
})

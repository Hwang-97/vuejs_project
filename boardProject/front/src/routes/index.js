import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "../view/Home.vue"
import Etc from "../view/Etc.vue"
import Board from "../view/board/Board.vue"
import BoardCreate from "../view/board/BoardCreate";
import BoardDetail from "../view/board/BoardDetail";
import BoardLay from "../layout/BoardLay";
import beforeEach from "./beforeEach";

export default createRouter({
    history:createWebHashHistory(),
    beforeEach : beforeEach,
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
                    component: BoardDetail,
                },
                {
                    path: "create",
                    component: BoardCreate,
                }
            ]
        },
        {
            path: "/etc",
            component:Etc
        },

    ]
})

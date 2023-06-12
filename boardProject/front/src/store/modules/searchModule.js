// modules/searchModule.js
const namespaced = true;
const state = {
    typeFlag: "title",
    searchText: ""
};
const getters = {
    getTypeFlag(state) {
        return state.typeFlag;
    },
    getSearchText(state) {
        return state.searchText;
    }
};
const mutations = {
    setTypeFlag(state,data) {
        state.typeFlag = data
    },
    setSearchText(state,data) {
        state.searchText = data
    }
};

// 비동기를 사용할 때, 또는 여러 mutations를 연달아 송출할 때 사용.
// EX) 사용자 정보 확인.(권한 check)
const action = {

};
export default {
    namespaced,
    state,
    getters,
    mutations,
    action
};

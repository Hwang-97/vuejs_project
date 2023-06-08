<template>
  <Search
      :board-flag="true"
      @search:fnGetList="fnGetList">
  </Search>
  <div class="container board">
    <div class="table-responsive small">
      <table class="table table-striped ">
        <colgroup>
          <col width="100px"/>
          <col width="150px"/>
          <col width="100px"/>
          <col width="*"/>
          <col width="200px"/>
          <col width="100px"/>
        </colgroup>
        <thead>
        <tr table-header>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>내용</th>
          <th>작성일자</th>
          <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(row, idx) in list"
            :key="idx"
            @click="fnView(`${row.id}`)">
          <td>{{ row.id }}</td>
          <td>{{ row.title }}</td>
          <td>{{ row.author }}</td>
          <td>{{ row.content }}</td>
          <td>{{ row.createdAt.substr(0, 10) }}</td>
          <td>
            <div
                @click.stop="deleteRow(`${row.id}`)"
                v-if="row.isDeletable"
                class="btn btn-primary">
              삭제
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <pagination
        :current-page="currentPage"
        :total-pages="totalPages"
        @update:current-page="setCurrentPage"
    ></pagination>
  </div>
</template>

<script>
import Search from "../../components/Search.vue";
import axios from "axios";
import Pagination from "../../components/Paging";

export default {
  components: {
    Pagination,
    Search
  },
  props: {
    typeFlag: {
      type: String,
      default: ""
    },
    content: {
      type: String,
      default: ""
    }
  },
  created() {
    console.log(this.$route.params.typeFlag);
    console.log(this.$route.params.content);
  },
  data() { //변수생성
    return {
      currentPage: 1,
      totalPages: 1,
      list: {}, //리스트 데이터
    }
  },
  mounted() {
    const typeFlag = this.$route.params.typeFlag;
    const content = this.$route.params.content;

    if (typeFlag == "" && content == "") {
      this.fnGetList()
    } else {
      this.fnGetList({typeFlag: typeFlag, content: content})
    }
  },
  methods: {
    setCurrentPage(page) {
      this.currentPage = page;
      // Perform any data fetching or updating based on the new page
    },
    deleteRow(id) {
      if (confirm("해당 내용을 삭제하시겠습니까?")) {

      }
    },
    fnView(id) {
      const url = "/board/detail"
      this.$router.push({
        path: url,
        query: {
          id: id
        },
      });
    },
    fnGetList(data) {
      axios.get("/api/boardList", {
        params: data
      }).then((res) => {
        if (res.statusText == "OK") {
          this.list = res.data;
        } else {
          alert("데이터가 존재하지 않습니다.");
        }
      });
    }
  },
  name: "Board"
}
</script>

<style lang="scss" scoped>
.board {
  margin-top: 30px;
}

th {
  background-color: #64818e;
  color: white;
  font-weight: bold;
  font-family: "Oswald", sans-serif;
}

tbody {
  tr:hover {
    cursor: pointer;
  }
}
</style>

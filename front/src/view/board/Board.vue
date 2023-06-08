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
            @click="fnView(`${row.id}`)"
            height="40px">
          <td>{{ row.id }}</td>
          <td>{{ row.title }}</td>
          <td>{{ row.author }}</td>
          <td>{{ row.content }}</td>
          <td>{{ row.createdAt.substr(0, 10) }}</td>
          <td>
            <div
                @click.stop="deleteRow(`${row.id}`)"
                v-if="row.isDeletable"
                class="btn btn-primary btn-xs">
              삭제
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <pagination
        :current-page="pageData.page"
        :total-pages="pageData.totPage"
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
  data() { //변수생성
    return {
      list: {}, //리스트 데이터
      pageData:{
        page: 1,
        size: 10,
        totPage: 1,
        sort :"id,ASC",
      }
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    setCurrentPage(page) {
      this.pageData.page = page;
      this.fnGetList()
    },
    deleteRow(id) {
      if (confirm("해당 내용을 삭제하시겠습니까?")) {
        axios.delete("/api/board", {
          params: {"id" : id}
        }).then((res) => {
          if (res.statusText == "OK") {
            alert("정상적으로 삭제되었습니다.")
            this.fnGetList()
          } else {
            alert("삭제할 데이터가 존재하지 않습니다.\r\n리스트 화면으로 돌아갑니다.");
            this.fnGetList()
          }
        });
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
    fnGetList() {
      let data = {
        typeFlag    : this.$store.getters["search/getTypeFlag"],
        searchText  : this.$store.getters["search/getSearchText"]
      }
      data = Object.assign(data,this.pageData);
      axios.get("/api/board", {
        params: data
      }).then((res) => {
        if (res.statusText == "OK") {
          let tmpSize = Number(res.data[0]);
          tmpSize = Math.ceil(tmpSize/10);
          this.pageData.totPage = tmpSize;
          this.list = res.data.slice(1);
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

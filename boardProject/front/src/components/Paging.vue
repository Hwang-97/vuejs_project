<template>
  <nav class="pagination-container">
    <ul class="pagination justify-content-center">
      <li class="page-item" :class="{ disabled: currentPage === 1 }">
        <a class="page-link" href="#" @click.prevent="previousPage">Previous</a>
      </li>

      <li
        v-for="page in totalPages"
        :key="page"
        class="page-item"
        :class="{ active: currentPage === page }"
      >
        <a class="page-link" href="#" @click.prevent="goToPage(page)">{{ page }}</a>
      </li>

      <li class="page-item" :class="{ disabled: currentPage === totalPages }">
        <a class="page-link" href="#" @click.prevent="nextPage">Next</a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Pagination',
  props: {
    currentPage: {
      type: Number,
      required: true
    },
    totalPages: {
      type: Number,
      required: true
    }
  },
  methods: {
    previousPage() {
      if (this.currentPage > 1) {
        this.$emit('update:current-page', this.currentPage - 1);
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.$emit('update:current-page', this.currentPage + 1);
      }
    },
    goToPage(page) {
      this.$emit('update:current-page', page);
    }
  }
};
</script>

<style scoped>
  .pagination-container {
    position: fixed;
    left: 0;
    bottom: 100px;
    width: 100%;
  }
</style>

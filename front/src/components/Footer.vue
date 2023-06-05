<template>
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top fixed-bottom">
        <p class="col-md-4 mb-0 text-muted">© 2023 Company, Inc</p>

        <a href="/" class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
            <img src="../assets/logo.png" class="bi" width="50" height="50">
        </a>

        <ul class="nav col-md-4 justify-content-end">
          <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
          <li class="nav-item"><a href="/#/etc" class="nav-link px-2 text-muted">Etc</a></li>
        </ul>
      </footer>
</template>

<script>
export default {
  name: "Footer",
};
</script>

<style scoped>
footer {
  padding-left: 50px;
  padding-right: 50px;
}
</style>

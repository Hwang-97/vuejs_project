<template>
  <div class="modal">
    <div class="modal-content">
      <div class="container my-3">
          <!-- 질문 -->
          <h2 class="border-bottom py-2"></h2>
          <div class="card my-3">
              <div class="card-body">
                  <div class="card-text" style="white-space: pre-line;"></div>
                  <div class="d-flex justify-content-end">
                      <div class="badge bg-light text-dark p-2">

                      </div>
                  </div>
              </div>
          </div>
          <!-- 답변 목록 -->
          <h5 class="border-bottom my-3 py-2">개의 답변이 있습니다.</h5>
          <div class="card my-3">
              <div class="card-body">
                  <div class="card-text" style="white-space: pre-line;"></div>
                  <div class="d-flex justify-content-end">
                      <div class="badge bg-light text-dark p-2">

                      </div>
                  </div>
              </div>
          </div>
          <!-- 답변 등록 -->
          <form action="" method="post" class="my-3">
              <div class="mb-3">
                  <textarea name="content" id="content" class="form-control" rows="10"></textarea>
              </div>
              <input type="submit" value="답변등록" class="btn btn-primary">
          </form>
      </div>
    </div>
    <div class="modal-overlay" @click=""></div>
  </div>
</template>

<script>
export default {
  name: 'Modal'
};
</script>

<style>
/* 모달 스타일링 */
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background-color: #fff;
  padding: 20px;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}
</style>

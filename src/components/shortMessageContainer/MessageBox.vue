<template lang="html">
  <Card class="card">
    <p slot="title">
      <Avatar>U</Avatar>瞎bb
    </p>
    <div slot="extra">
      <Button type="ghost" shape="circle" icon="heart" @click="success">喜欢:120</Button>
      <Button type="error" shape="circle" icon="fireball">举报:2</Button>
    </div>
    <Card class="card">
      <div>
        <p>帖子全文</p>
      </div>
    </Card>
    <Input placeholder="评论" long style="margin-bottom: 1rem;">
      <span slot="append">
        <Button>发表</Button>
      </span>
    </Input>
    <Card v-for="item in items" class="card">
      <div>
        <a href="#">@xxx</a>: {{item}}
      </div>
    </Card>
  </Card>
</template>

<script>
export default {
  data() {
    return ({
      items: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    })
  }
}
</script>

<style lang="css">
.card {
  width: 100%;
  margin-bottom: 1rem;
}

.ivu-card-head p,
.ivu-card-head-inner {
  height: auto;
}

.float-left {
  float: right;
}
</style>

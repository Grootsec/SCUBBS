export default {
  proxyTable: {
    '/api': {
      target: 'http://www.api.com/api',
      changeOrigin: true,
      pathRewrite: {
        '^/api': ''
      }
    }
  },
}

import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  base: './',
  build: {
    chunkSizeWarningLimit: 1000,
    rollupOptions: {
      output: {
        manualChunks(id) {
          if (id.includes('problem-catalog.json')) return 'problem-catalog'
          if (id.includes('node_modules')) return 'vendor'
        },
      },
    },
  },
})

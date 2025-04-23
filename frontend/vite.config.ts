/// <reference types="vitest" />
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    outDir: 'build',
  },
  test: {
    globals: true,     environment: 'jsdom', // Simulates a browser environment
    setupFiles: './src/setupTest.ts', // File for test setup (see below)
    css: true, // Optional: Include CSS in tests if needed
  },
})

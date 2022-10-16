import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    name: 'taverne',
    path: '/taverne',
    alias: '/',
    component: () => import('pages/TaverneCategory.vue'),
  },
  {
    path: '/kampf',
    component: () => import('pages/KampfCategory.vue'),
  },
  {
    path: '/haendler',
    component: () => import('pages/HaendlerCategory.vue'),
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;

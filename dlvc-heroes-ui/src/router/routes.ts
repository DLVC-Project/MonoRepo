import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    name: 'taverne',
    path: '/taverne',
    alias: '/',
    component: () => import('pages/TaverneCategory.vue'),
    /* children: [  TODO: Refactor children usage
      {
        name: 'spieler',
        path: '/taverne/spieler',
        component: () => import('pages/TaverneSpielerCategory.vue'),
      },
    ] */
  },
  {
    name: 'spieler',
    path: '/taverne/spieler',
    component: () => import('pages/TaverneSpielerCategory.vue'),
  },
  {
    name: 'gruppe',
    path: '/taverne/gruppe',
    component: () => import('pages/TaverneGruppeCategory.vue'),
  },
  {
    name: 'abenteuer',
    path: '/taverne/abenteuer',
    component: () => import('pages/TaverneAbenteuerCategory.vue'),
  },
  {
    name: 'kampf',
    path: '/kampf',
    component: () => import('pages/KampfCategory.vue'),
  },
  {
    name: 'haendler',
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

<template>
  <q-layout view="hHh lpR fFf">
    <q-header reveal elevated class="bg-primary text-white" height-hint="98">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg" />
          </q-avatar>
          DLVC
        </q-toolbar-title>

        <!-- <q-tabs align="left"> -->
        <div>Ho Valavor v{{ version }}</div>
      </q-toolbar>
      <q-tabs
        class="bg-primary text-white shadow-2">
        <q-route-tab to="taverne" label="Taverne" icon="liquor" />
        <q-route-tab to="kampf" label="Kampf" icon="fa-solid fa-khanda" />
        <q-route-tab to="haendler" label="Händler" icon="storefront" />
      </q-tabs>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
      <q-list>
        <q-item-label header> Funktionen </q-item-label>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { version } from '../../package.json';
import EssentialLink, {
  EssentialLinkProps,
} from 'components/EssentialLink.vue';

const essentialLinks: EssentialLinkProps[] = [
  {
    title: 'Spieler',
    caption: 'Erstellen | Bearbeiten',
    icon: 'emoji_people',
    link: 'https://quasar.dev',
  },
  {
    title: 'Gruppe',
    caption: 'Erstellen | Bearbeiten',
    icon: 'diversity_3',
    link: 'https://github.com/quasarframework',
  },
];

const leftDrawerOpen = ref(false);

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value;
}
</script>

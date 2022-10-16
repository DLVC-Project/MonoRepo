<!-- TODO: Parametrisieren! -->
<template>
  <div class="q-pa-md" style="max-width: 250px">
    <q-list padding class="rounded-borders text-primary">
      <q-item
        clickable
        v-ripple
        :active="link === 'Spieler'"
        @click="link = 'Spieler'"
        active-class="my-menu-link"
        to="taverne/spieler"
      >
        <q-item-section avatar>
          <q-icon name="emoji_people" />
        </q-item-section>

        <q-item-section>Spieler</q-item-section>
      </q-item>

      <q-item
        clickable
        v-ripple
        :active="link === 'Gruppe'"
        @click="link = 'Gruppe'"
        active-class="my-menu-link"
        to="taverne/gruppe"
      >
        <q-item-section avatar>
          <q-icon name="diversity_3" />
        </q-item-section>

        <q-item-section>Gruppe</q-item-section>
      </q-item>

      <q-item
        clickable
        v-ripple
        :active="link === 'Abenteuer'"
        @click="link = 'Abenteuer'"
        active-class="my-menu-link"
        to="taverne/abenteuer"
      >
        <q-item-section avatar>
          <q-icon name="hiking" />
        </q-item-section>

        <q-item-section>Abenteuer</q-item-section>
      </q-item>
    </q-list>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  setup () {
    return {
      link: ref('inbox')
    }
  }
}
</script>

<style lang="sass">
.my-menu-link
  color: white
  background: #F2C037
</style>

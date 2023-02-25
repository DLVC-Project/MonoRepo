<template>
  <div class="q-pa-md">
    <q-form class="q-gutter-md" style="max-width: 300px">
      <q-input outlined v-model="playerData.name" label="Name">
        <template v-slot:append>
          <q-icon name="emoji_people" />
        </template>
      </q-input>
      <div class="row justify-between">
        <div class="col-5">
          <q-input
            outlined
            v-model.number="playerData.level"
            type="number"
            label="Kreis"
          />
        </div>
        <div class="col-6">
          <q-input
            outlined
            v-model.number="playerData.level"
            type="number"
            label="Level"
          >
            <template v-slot:append>
              <q-icon name="book" />
            </template>
          </q-input>
        </div>
      </div>
      <q-input outlined v-model="playerData.defR" type="number" label="Def/R">
        <template v-slot:append>
          <q-icon name="shield" />
        </template>
      </q-input>
      <q-input outlined v-model="playerData.defH" type="number" label="Def/H">
        <template v-slot:append>
          <q-icon name="sports_motorsports" />
        </template>
      </q-input>
      <q-input
        outlined
        v-model="playerData.dmg1"
        type="number"
        label="Schaden 1"
      >
        <template v-slot:append>
          <q-icon name="construction" />
        </template>
      </q-input>
      <q-input
        outlined
        v-model="playerData.dmg2"
        type="number"
        label="Schaden 2"
      >
        <template v-slot:append>
          <q-icon name="construction" />
        </template>
      </q-input>
      <simple-number-input label="abc" />

      <div>
        <q-btn label="Speichern" @click="onSubmit" color="primary" />
      </div>
    </q-form>
  </div>
</template>

<script lang="ts">
import { PlayerData } from 'src/Taverne/PlayerData';
import { ref, defineComponent, reactive } from 'vue';
import SimpleNumberInput from '../components/shared/SimpleNumberInput.vue';

export default defineComponent({
  setup() {
    const playerData = reactive<PlayerData>({
      name: 'Jane Doe',
      level: 0,
      defH: 0,
      defR: 0,
      dmg1: 0,
      dmg2: 0,
      dmg3: 0,
    });
    const onSubmit = () => {
      console.log(playerData);
      // TODO
      // axios.post
      // angelegetes Objekt als Antwort in **pinia** speichern -> verbindet Componenten
    };
    return {
      playerData,
      onSubmit,
    };
  },
  components: { SimpleNumberInput },
});
</script>

<template>
  <div class="q-pa-md">
    <div class="q-gutter-md" style="max-width: 300px">
      <q-input outlined v-model="charName" label="Name" />
      <q-input
        outlined
        v-model.number="model"
        type="number"
        label="Kreis.Level"
      />
      <q-input
        filled
        v-model="level"
        label="Erfahrung"
        mask="Kreis: #    |    Level: ##"
        unmasked-value
        hint="Kreis: #    |    Level: ##"
      />
      <q-input outlined v-model="defR" type="number" label="Def/R" />
      <q-input outlined v-model="defH" type="number" label="Def/H" />
      <q-input outlined v-model="dmg1" type="number" label="Dmg 1" />
      <q-input outlined v-model="dmg2" type="number" label="Dmg 2" />
      <q-input outlined v-model="dmg3" type="number" label="Dmg 3" />
    </div>

    <div>
      <q-form @submit="onSubmit" class="q-gutter-md">
        <q-input
          name="name"
          v-model="name"
          color="primary"
          label="Full name"
          filled
          clearable
        />

        <div>
          <q-btn label="Submit" type="submit" color="primary" />
        </div>
      </q-form>

      <q-card
        v-if="submitResult.length > 0"
        flat
        bordered
        class="q-mt-md bg-grey-2"
      >
        <q-card-section
          >Submitted form contains the following formData (key =
          value):</q-card-section
        >
        <q-separator />
        <q-card-section class="row q-gutter-sm items-center">
          <div
            v-for="(item, index) in submitResult"
            :key="index"
            class="q-px-sm q-py-xs bg-grey-8 text-white rounded-borders text-center text-no-wrap"
          >
            {{ item.name }} = {{ item.value }}
          </div>
        </q-card-section>
      </q-card>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const submitResult = ref([]);

    return {
      name: ref('Jane Doe'),
      submitResult,
      text: ref(''),
      charName: ref(""),
      level: ref(null),
      defH: ref(),
      defR: ref(0),
      dmg1: ref(0),
      dmg2: ref(0),
      dmg3: ref(0),

      onSubmit(evt) {
        const formData = new FormData(evt.target);
        const data = [];

        for (const [name, value] of formData.entries()) {
          data.push({
            name,
            value,
          });
        }

        submitResult.value = data;
      },
    };
  },

  /*   setup() {
    return {
      text: ref(''),
      level: ref(null),
    };
  }, */
};
</script>

<template>
  <div class="q-pa-md">
    <q-form @submit="onSubmit" class="q-gutter-md" style="max-width: 300px">
      <q-input outlined v-model="charName" label="Name" >
        <template v-slot:append>
          <q-icon name="emoji_people"/>
        </template>
      </q-input>
      <div class="row justify-between">
        <div class="col-5">
          <q-input
            outlined
            v-model.number="model"
            type="number"
            label="Kreis"
          />
        </div>
        <div class="col-6">
          <q-input
            outlined
            v-model.number="model"
            type="number"
            label="Level"
            >
            <template v-slot:append>
              <q-icon name="book"/>
            </template>
          </q-input>
        </div>
      </div>
      <q-input outlined v-model="defR" type="number" label="Def/R" >
        <template v-slot:append>
          <q-icon name="shield"/>
        </template>
      </q-input>
      <q-input outlined v-model="defH" type="number" label="Def/H" >
        <template v-slot:append>
          <q-icon name="sports_motorsports"/>
        </template>
      </q-input>
      <q-input outlined v-model="dmg1" type="number" label="Schaden 1" >
        <template v-slot:append>
          <q-icon name="construction"/>
        </template>
      </q-input>
      <q-input outlined v-model="dmg2" type="number" label="Schaden 2" >
        <template v-slot:append>
          <q-icon name="construction"/>
        </template>
      </q-input>
      <simple-number-input label="abc"/>

      <div>
        <q-btn label="Speichern" type="submit" color="primary" />
      </div>

    </q-form>
    <q-card
      v-if="submitResult.length > 0"
      flat
      bordered
      class="q-mt-md bg-grey-2"
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

    <!-- <div>
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
    </div> -->
  </div>
</template>

<script>
import { ref } from 'vue';
import SimpleNumberInput from '../components/shared/SimpleNumberInput.vue';

export default {
    setup() {
        const submitResult = ref([]);
        return {
            name: ref("Jane Doe"),
            submitResult,
            text: ref(""),
            charName: ref(""),
            level: ref(null),
            defH: ref(),
            defR: ref(),
            dmg1: ref(),
            dmg2: ref(),
            dmg3: ref(),
            onSubmit(evt) {
                const formData = new FormData(evt.target);
                const data = [];
                for (const [name, level] of formData.entries()) {
                    data.push({
                        name,
                        level,
                    });
                }
                submitResult.value = data;
            },
        };
    },
    components: { SimpleNumberInput }
};
</script>

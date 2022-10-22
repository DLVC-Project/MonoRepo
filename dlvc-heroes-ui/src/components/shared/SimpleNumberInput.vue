<template>
 <q-input outlined type="number" :model-value="value" :label="label" @input="handleInput" >
    <template v-slot:append>
      <q-icon name="shield"/>
    </template>
  </q-input>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'TextInput',
  props: {
    label: {
      type: String,
      required: false,
      default: '',
    }
  },
  data() {
    return {
      value: Number,
    };
  },
  methods: {
    handleInput($event: { target: { value: NumberConstructor; }; }) {
      this.value = $event.target.value;
    },
  },
});
  /* let label: string;
  let value: number;
  let input: number;

  function handleInput($event) {
    this $event.target.value
  } */
</script>

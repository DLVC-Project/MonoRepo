<template>
 <q-input outlined type="number" :model-value="valueContainer" :label="label" @input="handleInput" >
    <template v-slot:append>
      <q-icon name="shield"/>
    </template>
  </q-input>
</template>

<script setup lang="ts">
import { defineComponent, ref } from 'vue'

defineComponent({
  name: 'TextInput',
  props: {
    label: {
      type: String,
      required: false,
      default: '',
    }
  },
  /* data() {
    return {
      value: Number,
    };
  }, */
  /* methods: {
    handleInput($event: { target: { value: NumberConstructor; }; }) {
      this.value = $event.target.value;
    },
  }, */
});
const valueContainer = ref<number>();
const label = '';
function handleInput($event: { target: { value: number; }; }) {
      valueContainer.value = $event.target.value;
      console.log(valueContainer.value);
    }
</script>

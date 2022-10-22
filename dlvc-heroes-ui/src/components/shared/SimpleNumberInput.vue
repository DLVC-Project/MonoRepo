<template>
 <q-input outlined type="number" :value="value" :label="label" @input="handleInput" >
    <template v-slot:append>
      <q-icon name="shield"/>
    </template>
  </q-input>
</template>

<script>
export default {
  name: 'TextInput',
  props: {
    label: {
      type: String,
      required: false,
      default: "",
    }
  },
  data() {
    return {
      value: "",
    };
  },
  methods: {
    handleInput($event) {
      this.value = $event.target.value;
    },
  },
};
  /* let label: string;
  let value: number;
  let input: number;

  function handleInput($event) {
    this $event.target.value
  } */
</script>

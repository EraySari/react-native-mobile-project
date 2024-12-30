import Toast from "react-native-toast-message";

const toast = {
  success: (message, description) => {
    Toast.show({
      type: "success",
      text1: message,
      text2: description,
    });
  },
  error: (message, description) => {
    Toast.show({
      type: "error",
      text1: message,
      text2: description,
    });
  },
  info: (message, description) => {
    Toast.show({
      type: "info",
      text1: message,
      text2: description,
    });
  },
};

export default toast;

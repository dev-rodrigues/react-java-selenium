import React from 'react';
import ReactDOM from 'react-dom';
import { ChakraProvider } from '@chakra-ui/react';
import {QueryClient, QueryClientProvider} from 'react-query';

import App from './App';
import reportWebVitals from './reportWebVitals';

import {theme} from "./styles/themes";

export const queryClient = new QueryClient();

ReactDOM.render(
  <React.StrictMode>
      <QueryClientProvider client={queryClient}>
          <ChakraProvider resetCSS theme={theme}>
                  <App />
          </ChakraProvider>
      </QueryClientProvider>
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();

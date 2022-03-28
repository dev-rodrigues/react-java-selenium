import {
    FormControl, FormErrorMessage,
    FormLabel,
    Input as ChakraInput,
    InputProps as ChakraInputProps
} from "@chakra-ui/react";
import { FieldError } from 'react-hook-form';
import {forwardRef, ForwardRefRenderFunction} from "react";

interface InputProps extends ChakraInputProps{
    teste: string;
    label?: string;
    error?: FieldError;
}

const InputBase:ForwardRefRenderFunction<HTMLInputElement, InputProps> = ({
                                                                              teste,
                                                                              error = undefined,
                                                                              label,
                                                                              ...rest
}: InputProps, ref) => {

    return (
        <FormControl isInvalid={!!error}>
            {!! label && <FormLabel htmlFor={teste}>{label}</FormLabel>}
            <ChakraInput
                id={teste}
                name={teste}
                focusBorderColor="pink.500"
                bgColor="gray.900"
                variant="filled"
                _hover={{
                    bgColor: 'gray.900'
                }}
                size="lg"
                ref={ref}
                {...rest}
            />
            {!! error && <FormErrorMessage>{error.message}</FormErrorMessage>}
        </FormControl>
    );
}

export const Input = forwardRef(InputBase);
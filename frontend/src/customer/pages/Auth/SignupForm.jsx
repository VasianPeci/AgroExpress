import { Button, CircularProgress, TextField } from '@mui/material';
import React from 'react';
import { useFormik } from 'formik';
import { useAppDispatch, useAppSelector } from '../../../Redux Toolkit/Store';
import { signup } from '../../../Redux Toolkit/Customer/AuthSlice';
import { useNavigate } from 'react-router-dom';

const SignupForm = () => {
    const navigate = useNavigate();
    const dispatch = useAppDispatch();
    const auth = useAppSelector(store => store.auth);

    const formik = useFormik({
        initialValues: {
            email: '',
            name: ''
        },
        onSubmit: (values) => {
            dispatch(signup({ fullName: values.name, email: values.email, navigate }));
            console.log('Form data:', values);
        }
    });

    return (
        <div>
            <h1 className='text-center font-bold text-xl text-primary-color pb-5'>Signup</h1>
            <form className="space-y-5" onSubmit={formik.handleSubmit}>
                <TextField
                    fullWidth
                    name="email"
                    label="Enter Your Email"
                    value={formik.values.email}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.email && Boolean(formik.errors.email)}
                    helperText={formik.touched.email ? formik.errors.email : undefined}
                />

                <TextField
                    fullWidth
                    name="name"
                    label="Enter Your Name"
                    value={formik.values.name}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.name && Boolean(formik.errors.name)}
                    helperText={formik.touched.name ? formik.errors.name : undefined}
                />

                <Button
                    disabled={auth.loading}
                    type="submit"
                    fullWidth
                    variant='contained'
                    sx={{ py: "11px" }}
                >
                    {auth.loading ? <CircularProgress size={24} /> : "Signup"}
                </Button>
            </form>
        </div>
    );
};

export default SignupForm;

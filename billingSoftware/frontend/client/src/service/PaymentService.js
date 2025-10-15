import axios from "axios";

export const createRazorpayOrder = async (data) => {
    return await axios.post(`http://localhost:8080/api/v1.0/payments/create-order`, data, {headers: {'Authorization': `Bearer ${localStorage.getItem('token')}`}});
}

export const verifyPayment = async (paymentData) => {
    return await axios.post(`http://localhost:8080/api/v1.0/payments/verify`, paymentData, {headers: {'Authorization': `Bearer ${localStorage.getItem('token')}`}});
}

export const deleteOrder = async (id) => {
    return await axios.delete(`http://localhost:8080/api/v1.0/orders/${id}`, {headers:{'Authorization': `Bearer ${localStorage.getItem('token')}`}});
}
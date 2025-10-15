import { useContext } from 'react';
import './Item.css';
import { AppContext } from '../../context/AppContext';

const Item = ({ itemName, itemPrice, itemImage, itemId }) => {
    const { addToCart } = useContext(AppContext);

    const handleAddToCart = () => {
        addToCart({
            name: itemName,
            price: itemPrice,
            quantity: 1,
            itemId: itemId
        });
    };

    return (
        <div className="item-card bg-dark shadow-sm rounded p-3 d-flex">
            <img src={itemImage} alt={itemName} className="item-image" />

            <div className="item-details flex-grow-1">
                <h6 className="text-light mb-1">{itemName}</h6>
                <p className="text-light fw-bold mb-0">₹{itemPrice}</p>
            </div>

            <div className="item-actions d-flex flex-column align-items-center justify-content-between">
                <i className="bi bi-cart-plus fs-4 text-warning"></i>
                <button className="btn btn-success btn-sm" onClick={handleAddToCart}>
                    <i className="bi bi-plus"></i>
                </button>
            </div>
        </div>
    );
};

export default Item;

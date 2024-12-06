import { useEffect, useState } from "react";
import { Product } from "../../app/models/product";
import ProductList from "./ProductList";
import agent from "../../app/api/agent";
import Spinner from "../../app/layout/Spinner";

export default function Catalog(){
    const [products, setProducts] = useState<Product[]>([]);
    const [loading, setLoading] = useState(true);
    // useEffect(()=>{
    //     fetch('http://localhost:8081/api/products')
    //     .then(response => response.json())
    //     .then(data=>setProducts(data.content));
    // },[]);

    useEffect(() => {
      agent.Store.list()
      .then((products) => setProducts(products.content))
      .catch(error => console.log(error))
      .finally(()=>setLoading(false));
    }, []);

    if(!products) return <h3>Unable to load Products</h3>
    if(loading) return <Spinner message='Loading Products...'/>

    return(
      <ProductList products={products}/>
        // <ul>
        //   {products.map(product=>(
        //   <div key={product.id}>
        //     <p>Name: {product.name}</p>
        //     <p>Description: {product.description}</p>
        //     <p>Price: ${product.price}</p>
        //     <p>Brand: {product.productBrand}</p>
        //     <p>Type: {product.productType}</p>
        //   </div>
        // ))}
        // </ul>
        )
}
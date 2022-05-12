let access = confirm('Are you of age ?');
const accessDenied = ()=> {
	let body = document.body;
	let bodyChildren = body.childNodes;
	for (let child of bodyChildren)
	{
		if(child.nodeType === Node.ELEMENT_NODE )
		{
				body.removeChild(child)
		}	
	}
	let p = document.createElement('p')
	p.appendChild(document.createTextNode('access denied'))
	body.appendChild(p)
}

const accessAllowed = ()=>
{
	alert("Welcome my brother");
}

(access)? accessAllowed():accessDenied()

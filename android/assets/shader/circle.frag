#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture2;
varying vec2 v_textCoords2;
uniform float u_origin_begin_u;
uniform float u_origin_begin_v;
uniform float u_scale;
uniform float v_scale;


void main() {
    vec4 tempColor;
    vec2 v_textCoords2 = vec2((v_textCoords.x)/u_scale,(v_textCoords.y)/v_scale);
    if(v_textCoords2.x>1.0 || v_textCoords2.y>1.0 || v_textCoords2.x<0.0 || v_textCoords2.y<0.0){
        tempColor = vec4(0.0,0.0,0.0,0.0);
    }else{
        tempColor = texture2D(u_texture2,v_textCoords2);
    }
	vec4 color = v_color* texture2D(u_texture, v_textCoords);
	gl_FragColor = color;
	gl_FragColor.a = color.a* tempColor.a;
}